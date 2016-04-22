package com.ddyun.security

import grails.gorm.DetachedCriteria
import groovy.transform.ToString

import org.apache.commons.lang.builder.HashCodeBuilder

@ToString(cache=true, includeNames=true, includePackage=false)
class MemberAuthority implements Serializable {

	private static final long serialVersionUID = 1

	Member member
	Authority authority

	MemberAuthority(Member u, Authority r) {
		this()
		member = u
		authority = r
	}

	@Override
	boolean equals(other) {
		if (!(other instanceof MemberAuthority)) {
			return false
		}

		other.member?.id == member?.id && other.authority?.id == authority?.id
	}

	@Override
	int hashCode() {
		def builder = new HashCodeBuilder()
		if (member) builder.append(member.id)
		if (authority) builder.append(authority.id)
		builder.toHashCode()
	}

	static MemberAuthority get(long memberId, long authorityId) {
		criteriaFor(memberId, authorityId).get()
	}

	static boolean exists(long memberId, long authorityId) {
		criteriaFor(memberId, authorityId).count()
	}

	private static DetachedCriteria criteriaFor(long memberId, long authorityId) {
		MemberAuthority.where {
			member == Member.load(memberId) &&
			authority == Authority.load(authorityId)
		}
	}

	static MemberAuthority create(Member member, Authority authority, boolean flush = false) {
		def instance = new MemberAuthority(member, authority)
		instance.save(flush: flush, insert: true)
		instance
	}

	static boolean remove(Member u, Authority r, boolean flush = false) {
		if (u == null || r == null) return false

		int rowCount = MemberAuthority.where { member == u && authority == r }.deleteAll()

		if (flush) { MemberAuthority.withSession { it.flush() } }

		rowCount
	}

	static void removeAll(Member u, boolean flush = false) {
		if (u == null) return

		MemberAuthority.where { member == u }.deleteAll()

		if (flush) { MemberAuthority.withSession { it.flush() } }
	}

	static void removeAll(Authority r, boolean flush = false) {
		if (r == null) return

		MemberAuthority.where { authority == r }.deleteAll()

		if (flush) { MemberAuthority.withSession { it.flush() } }
	}

	static constraints = {
		authority validator: { Authority r, MemberAuthority ur ->
			if (ur.member == null || ur.member.id == null) return
			boolean existing = false
			MemberAuthority.withNewSession {
				existing = MemberAuthority.exists(ur.member.id, r.id)
			}
			if (existing) {
				return 'userRole.exists'
			}
		}
	}

	static mapping = {
		id composite: ['member', 'authority']
		version false
	}
}
