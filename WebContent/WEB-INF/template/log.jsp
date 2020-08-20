 <div class="desc">
				<div class="info">
					<div class="left">
						<img src="img/cos.jpg" width="500" height="300" />
					</div>
					<div class="right">
						<%
						if(session.getAttribute("user")==null){
					%>
					<h3>s'identifier</h3>
						<form action="LoginServlet" method="POST">
							<label for="user">Nom d'utilisateur: </label>
							<input type="text" id="user" name="user" required>
							<label for="pass">Mote de passe:</label>
							<input type="password" id="pass" name="passe" required><br>
							<input type="submit" value="Entrer">
						</form>
					
					<%
						}
					else{
					%>
						<h3>Bienvenue, <%= session.getAttribute("user") %></h3>
						<form action="LogoutServlet" method="POST">
    						<input type="submit" value="Se déconnecte" size="100" />
						</form>
						<%
					}
					%>
					</div>
				 </div>
 </div>