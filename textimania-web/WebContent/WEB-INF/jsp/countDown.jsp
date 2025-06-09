<%@ include file="/common/taglibs.jsp"%>

<html>
	<head>
		<title>Everywhere you go</title>
	</head>
	<body>
		<table style="width: 700px;">
			<tr>
				<td class="windowHeader">Question #<s:property value="contestState.questionIndex" /></td>
			</tr>
			<tr>
				<td class="windowPanel">
					<div id="questionInnerDiv" style="border: solid 1px #4f81bd; background: #ffffff; padding: 4px; height: 600px; width: 950px; overflow: auto;">
						<div id="countdown"></div>			
						
						<script src="assets/countdown/jquery.countdown.js"></script>
						<script src="assets/js/script.js"></script>
						
						<s:if test="question.imagePath == null">
						<div class="question">
							<s:property value="question.textValue" escape="false" />							
						</div>
						</s:if>
						<table>
							<tr>
								<td width="200px"></td>
								<td>
									<s:if test="question.imagePath != null">
										<img src='${pageContext.request.contextPath}/picQuestions/<s:property value="question.imagePath" />' />
									</s:if>
								</td>
							</tr>
						</table>							
					</div>
				</td>
			</tr>
		</table>
	</body>
</html>