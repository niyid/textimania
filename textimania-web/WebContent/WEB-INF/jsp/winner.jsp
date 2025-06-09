<%@ include file="/common/taglibs.jsp"%>

<html>
	<head>
		<title>Winner Selection</title>
	</head>
	<body>
		<table style="width: 700px;">
					<tr>
						<td class="windowHeader">
							Contestant Scores
						</td>
					</tr>
					<tr>
						<td class="windowPanel">
							<div id="resultInnerDiv" style="border: solid 1px #4f81bd; background: #ffffff; padding: 4px; height: 300px; width: 950px; overflow: auto; font-size: 20px;">
								<table class="data-listing">
									<thead>
										<tr>
											<td>Contestant</td>
											<td align="right">Score</td>
										</tr>
									</thead>
									
									<s:iterator value="contestants" status="row">
										<tr>
											<td><s:property value="deviceId" /></td>							
											<td align="right"><s:property value="score" /></td>							
											</div>
										</tr>
									</s:iterator>
								</table>
							</div>
						</td>
					</tr>
				</table>
	</body>
</html>
