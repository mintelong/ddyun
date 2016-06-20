import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_ddyun_indexindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/index/index.gsp" }
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
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',7,[:],3)
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
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
expressionOut.print(resource(dir:'images',file:'Ibg.png'))
printHtmlPart(5)
loop:{
int i = 0
for( news in (newsList) ) {
printHtmlPart(6)
if(true && (i <8)) {
printHtmlPart(7)
expressionOut.print(news.id)
printHtmlPart(8)
expressionOut.print(news.title)
printHtmlPart(9)
}
printHtmlPart(10)
i++
}
}
printHtmlPart(11)
expressionOut.print(resource(dir:'images',file:'专精特新领军企业.jpg'))
printHtmlPart(12)
expressionOut.print(resource(dir:'images',file:'上海博物馆藏国之魂宝牺尊.jpg'))
printHtmlPart(13)
expressionOut.print(resource(dir:'images',file:'温馨塘桥宜居生活.jpg'))
printHtmlPart(14)
expressionOut.print(resource(dir:'images',file:'dadulogo.png'))
printHtmlPart(15)
expressionOut.print(resource(dir:'images/temp',file:'case.png'))
printHtmlPart(16)
loop:{
int i = 0
for( news in (newsList) ) {
printHtmlPart(6)
if(true && (i <8)) {
printHtmlPart(7)
expressionOut.print(news.id)
printHtmlPart(8)
expressionOut.print(news.title)
printHtmlPart(9)
}
printHtmlPart(10)
i++
}
}
printHtmlPart(17)
for( news in (newsList) ) {
printHtmlPart(18)
expressionOut.print(news.id)
printHtmlPart(8)
expressionOut.print(news.title)
printHtmlPart(19)
}
printHtmlPart(20)
expressionOut.print(resource(dir: 'js', file: 'jquery.min.js'))
printHtmlPart(21)
})
invokeTag('captureBody','sitemesh',156,[:],1)
printHtmlPart(22)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1466088057865L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
