<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ include file="/common/taglibs.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
<sj:head jqueryui="true" jquerytheme="redmond" />
        <!-- This files are needed for AJAX Validation of XHTML Forms -->
        <script language="JavaScript" src="${pageContext.request.contextPath}/struts/utils.js" type="text/javascript"></script>
        <script language="JavaScript" src="${pageContext.request.contextPath}/struts/xhtml/validation.js" type="text/javascript"></script>
        <link rel="stylesheet" href="assets/countdown/jquery.countdown.css" />
        
        <title><decorator:title default="MTN Textimania!" /></title>
<%@ include file="/common/meta.jsp"%>        
<decorator:head />
</head>
<body <decorator:getProperty property="body.id" writeEntireProperty="true"/> <decorator:getProperty property="body.class" writeEntireProperty="true"/>>

<div style="margin-bottom: 10px;" class="noprint">
<table style="width: 100%">
	<col width="150px" />
	<col />
	<tr>
		<td style="vertical-align: top; padding-right: 10px;"><a href="<c:url value="/" />"><img src="<c:url value='/img/mtn_logo.jpg'/>" alt="Logo"
			style="float: left; width: 50px; height: 50px;" /></a></td>
		<td style="vertical-align: top;">		
			<h1 style="margin: 0px 0px 3px 0px; padding: 0px; font: 'Comic Sans'; font-size: 4.5em; color: #0076A1;">MTN Textimania!</h1>
		</td>
	</tr>
</table>
</div>

<div class="noprint" style="border-top: solid 1px black; background-color: #FFCA08; color: #E41E2B; min-height: 16px; padding: 3px 10px 2px 10px; font-weight: bold;">
<decorator:title default="Untitled page" /></div>
	
<div style="margin: 10px 10px 0px 10px;">

<div id="main"><decorator:body /></div>
</div>	
</body>
</html>
