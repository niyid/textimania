<%@ include file="/common/taglibs.jsp"%>
<html>
	<head>
		<title>Everywhere you go</title>
	</head>
	<body>
		<div id="mainDiv">
			<div>
				<s:url var="restartContestUrl" action="host" namespace="/ajax" method="restart" />
				<span style="white-space: nowrap;">
					<sj:a 
				   	    href="%{restartContestUrl}" 
				        targets="mainDiv" 
				        button="true"
				        effect="highlight" 
				        buttonIcon="ui-icon-flag"
				        cssStyle="width: 200px; height: 40px; font-size: 15px; color: #0076A1;"
				        indicator="indicator">
						Restart current contest
					</sj:a>
				</span>
			</div>

			<div>
				<s:form id="newContestForm" action="host!newContest" namespace="/ajax" theme="xhtml" validate="true">
					<s:textfield name="title" label="Title" labelSeparator=":" cssStyle="width: 200px;" required="true" />
					<s:textfield name="contestantCount" label="Number of Contestants" labelSeparator=":" cssStyle="width: 200px;" required="true" />
					<s:file name="questionFile" label="Questions Spreadsheet" labelSeparator=":" cssStyle="width: 200px;" required="true" />
					<sj:submit button="true" value="Create" buttonIcon="ui-icon-search" targets="mainDiv" effect="highlight" effectDuration="500" indicator="indicator" />
				</s:form>
				<s:include value="/common/msg.jsp" />
			</div>

			<img id="indicator" src="./img/indicator.gif" alt="Processing..." style="display:none" />								
			</span>
		</div>
	</body>
</html>
