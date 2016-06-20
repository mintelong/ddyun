import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_ddyun_companycompanynews_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/company/companynews.gsp" }
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
invokeTag('captureMeta','sitemesh',7,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("keywords"),'content':("")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',8,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("description"),'content':("")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',9,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("viewport"),'content':("width=device-width, initial-scale=1.0")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',10,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("viewport"),'content':("width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no")],-1)
printHtmlPart(1)
})
invokeTag('captureHead','sitemesh',11,[:],1)
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
for( n in (nlist) ) {
printHtmlPart(12)
expressionOut.print(n.id)
printHtmlPart(13)
expressionOut.print(n.title)
printHtmlPart(14)
expressionOut.print(n.content)
printHtmlPart(15)
invokeTag('formatDate','g',90,['date':(n.date),'format':("yyyy-MM-dd")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
})
invokeTag('captureBody','sitemesh',128,[:],1)
printHtmlPart(18)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1465976599854L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
