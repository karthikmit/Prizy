<!DOCTYPE html>
<html>
	<head>
		%{--<meta name="layout" content="main"/>--}%
		<title>Welcome to Grails</title>
		<style type="text/css" media="screen">

                .home {
                    position: fixed;
                    top: 40%;
                    left: 35%;

                }
                .header {
                    position: fixed;
                    top: 0;
                    left: 0;
                    width: 100%;
                    height: 5em;
                    background-color: #ee82ee;
                }
                #data
                {
                    padding: 2em;
                    font-size: 100%
                }
                #research {
                    position: relative;
                    left: 5em;
                    padding: 2em;
                    font-size: 100%;
                }
                #title {
                    text-align: center;
                }

		</style>
	</head>
	<body>
        <div class="header">
            <h2 id="title">Welcome to Prizy, Price Research </h2>
        </div>

        <div class="home">
            <input type="button" value="Price Data Entry" id="data" onclick="document.location.href = '/Prizy/ProductLoader/index'"/>
            <input type="button" value="Price Research" id="research" onclick="document.location.href = '/Prizy/ProductInfo/index'"/>
        </div>
        <div class="footer">

        </div>
	</body>
</html>
