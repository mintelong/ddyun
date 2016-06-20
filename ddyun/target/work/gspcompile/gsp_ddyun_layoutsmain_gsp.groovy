import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_ddyun_layoutsmain_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/layouts/main.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',8,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',9,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("X-UA-Compatible"),'content':("IE=edge,chrome=1")],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('layoutTitle','g',10,['default':("大度云")],-1)
})
invokeTag('captureTitle','sitemesh',10,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',10,[:],2)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',11,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("viewport"),'content':("width=device-width, initial-scale=1.0")],-1)
printHtmlPart(2)
expressionOut.print(resource(dir: 'css', file: 'bootstrap.min.css'))
printHtmlPart(3)
expressionOut.print(resource(dir: 'css', file: 'style.css'))
printHtmlPart(3)
expressionOut.print(resource(dir: 'css', file: 'css.css'))
printHtmlPart(4)
invokeTag('layoutHead','g',21,[:],-1)
printHtmlPart(1)
invokeTag('layoutResources','r',22,[:],-1)
printHtmlPart(5)
createTagBody(2, {->
createClosureForHtmlPart(6, 3)
invokeTag('captureTitle','sitemesh',25,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',25,[:],2)
printHtmlPart(7)
createTagBody(2, {->
printHtmlPart(8)
invokeTag('username','sec',45,[:],-1)
printHtmlPart(9)
})
invokeTag('ifLoggedIn','sec',48,[:],2)
printHtmlPart(10)
createClosureForHtmlPart(11, 2)
invokeTag('ifNotLoggedIn','sec',57,[:],2)
printHtmlPart(12)
expressionOut.print(resource(dir:'images/temp',file:'logo.png'))
printHtmlPart(13)
})
invokeTag('captureHead','sitemesh',75,[:],1)
printHtmlPart(14)
createTagBody(1, {->
printHtmlPart(15)
invokeTag('layoutBody','g',78,[:],-1)
printHtmlPart(16)
expressionOut.print(resource(dir:'images/temp',file:'logo.png'))
printHtmlPart(17)
invokeTag('layoutResources','r',108,[:],-1)
printHtmlPart(18)
})
invokeTag('captureBody','sitemesh',109,[:],1)
printHtmlPart(19)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1466047751120L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
