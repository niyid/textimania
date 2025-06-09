<%@ include file="/common/taglibs.jsp"%>
<html>
	<head>
		<title>Everywhere you go</title>
	</head>
	<body>
		<div id="mainDiv">
			<s:url var="startContestUrl" action="host" namespace="/ajax" method="start" />
			<span style="white-space: nowrap;">
				<sj:a 
			   	    href="%{startContestUrl}" 
			        targets="mainDiv" 
			        button="true"
			        effect="highlight" 
			        buttonIcon="ui-icon-flag"
			        cssStyle="width: 250px; height: 100px; font-size: 45px; color: #0076A1;"
			        indicator="indicator">
					Start
				</sj:a>
			<img id="indicator" src="./img/indicator.gif" alt="Processing..." style="display:none" />								
			</span>
		</div>
	</body>
</html>
