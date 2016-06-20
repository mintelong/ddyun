import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_ddyun_companycompanyelite_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/company/companyelite.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'charset':("utf-8")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("renderer"),'content':("webkit")],-1)
printHtmlPart(1)
createTagBody(2, {->
invokeTag('captureTitle','sitemesh',7,[:],-1)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',8,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("keywords"),'content':("")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',9,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("description"),'content':("")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',10,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("viewport"),'content':("width=device-width, initial-scale=1.0")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',11,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("viewport"),'content':("width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no")],-1)
printHtmlPart(1)
})
invokeTag('captureHead','sitemesh',12,[:],1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
expressionOut.print(user.id)
printHtmlPart(4)
expressionOut.print(user.id)
printHtmlPart(5)
expressionOut.print(user.id)
printHtmlPart(6)
expressionOut.print(user.id)
printHtmlPart(7)
expressionOut.print(user.id)
printHtmlPart(8)
expressionOut.print(user.id)
printHtmlPart(9)
expressionOut.print(user.id)
printHtmlPart(10)
expressionOut.print(nc)
printHtmlPart(11)
for( e in (elist) ) {
printHtmlPart(12)
expressionOut.print(e.logo)
printHtmlPart(13)
expressionOut.print(e.name)
printHtmlPart(14)
expressionOut.print(e.englishName)
printHtmlPart(15)
expressionOut.print(e.title)
printHtmlPart(16)
expressionOut.print(e.shortResume)
printHtmlPart(17)
}
printHtmlPart(18)
})
invokeTag('captureBody','sitemesh',136,[:],1)
printHtmlPart(19)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1465976597659L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
