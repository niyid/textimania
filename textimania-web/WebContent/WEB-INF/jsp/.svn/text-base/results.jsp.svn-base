<%@ include file="/common/taglibs.jsp"%>

<html>
	<head>
		<title>Results</title>
	</head>
	<body>
		<div style="padding: 5px">
		<table style="width: 700px;">
			<tr>
				<td class="windowHeader">
					<s:a action="host" method="selectRoundWinner">
						<s:param name="winnerId">
							<s:property value="0" />
						</s:param>
						Answer #<s:property value="contestState.questionIndex" />
					</s:a>
				</td>
			</tr>
			<tr>
				<td class="windowPanel">
					<div id="answerInnerDiv" style="border: solid 1px #4f81bd; background: #ffffff; padding: 4px; height: 40px; width: 950px; overflow: auto;">
						<div class="answer"><s:property value="question.answer" /></div>
					</div>
				</td>
			</tr>
		</table>
		</div>

		<s:iterator value="results" status="row">
			<div style="padding: 5px">
				<table style="width: 700px;">
					<tr>
						<s:if test="#row.odd == true">
						<td class="windowHeader1">
							<s:a action="host" method="selectRoundWinner">
								<s:param name="winnerId">
									<s:property value="contestant.id" />
								</s:param>
								<s:property value="contestant.deviceId" />
							</s:a>
						</td>
						</s:if>
						<s:else>
						<td class="windowHeader">
							<s:a action="host" method="selectRoundWinner">
								<s:param name="winnerId">
									<s:property value="contestant.id" />
								</s:param>
								<s:property value="contestant.deviceId" />
							</s:a>
						</td>
						</s:else>
						
					</tr>
					<tr>
						<td class="windowPanel">
							<div style="color: #E41E2B; font-size: 15pt;">
								<s:if test="textValue != null">
									<s:property value="getText('format.secs', {responseTime})" /> seconds
								</s:if> 
								<s:else>
									No response
								</s:else>
							</div>
							<div id="resultInnerDiv" style="border: solid 1px #4f81bd; background: #ffffff; padding: 4px; height: 50px; width: 950px; overflow: auto; font-size: 25pt;">
								<b></b><s:property value="textValue" /></b>							
							</div>
						</td>
					</tr>
				</table>
			</div>
		</s:iterator>			
	</body>
</html>
