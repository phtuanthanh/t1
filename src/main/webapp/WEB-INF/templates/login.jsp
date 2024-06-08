<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>TransactSphere</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="https://fonts.googleapis.com/css?family=Press+Start+2P" rel="stylesheet">
    <link href="https://unpkg.com/nes.css/css/nes.css" rel="stylesheet" />

</head>
<style>
@charset "UTF-8";
*,
*:before,
*:after {
  box-sizing: border-box;
}
body {
  width: 100vw;
  height: 100vh;
  font-family: 'Press Start 2P';
  font-size: 14px;
  line-height: 1.3;
  background-color: #fff;
}
.inspiration {
  position: fixed;
  bottom: 0;
  right: 0;
  padding: 10px;
  text-align: center;
  text-decoration: none;
  font-family: 'Gill Sans', sans-serif;
  font-size: 12px;
  color: #fff;
}
.left {
  position: absolute;
  left: 0;
  width: 60vw;
  height: 100vh;
  background-image: linear-gradient(to right, #202020, #808080);
}
.right {
  position: absolute;
  right: 0;
  width: 60vw;
  height: 100vh;
  overflow: hidden;
}
.right .strip-top {
  width: calc(50vw + 90px);
  transform: skewX(20deg) translateX(160px);
}
.right .strip-bottom {
  width: calc(50vw - 59px);
  transform: skewX(-15deg) translateX(90px);
}
.center {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
}
.card {
  width: 600px;
  height: 355px;
}

.makeCen {
  position: absolute; left: 50%; top: 10%; transform: translate(-50%, -50%); display: flex; align-items: center;
}

.flip {
  width: inherit;
  height: inherit;
  transition: 0.7s;
  transform-style: preserve-3d;
  -webkit-animation: flip 2.5s ease;
          animation: flip 2.5s ease;
}
.front,
.back {
  position: absolute;
  width: inherit;
  height: inherit;
  border-radius: 15px;
  color: #fff;
  text-shadow: 0 1px 1px rgba(0,0,0,0.3);
  box-shadow: 0 1px 10px 1px rgba(0,0,0,0.3);
  -webkit-backface-visibility: hidden;
          backface-visibility: hidden;
  background-image: linear-gradient(to right, #111, #555);
  overflow: hidden;
}
.front {
  transform: translateZ(0);
}
.strip-bottom,
.strip-top {
  position: absolute;
  right: 0;
  height: inherit;
  background-image: linear-gradient(to bottom, #ff6767, #ff4545);
  box-shadow: 0 0 10px 0px rgba(0,0,0,0.5);
}
.strip-bottom {
  width: 200px;
  transform: skewX(-15deg) translateX(50px);
}
.strip-top {
  width: 310px;
  transform: skewX(20deg) translateX(80px);
}
.logo {
  position: absolute;
  top: 30px;
  right: 25px;
}
.investor {
  position: relative;
  top: 30px;
  left: 25px;
  text-transform: uppercase;
}
.chip {
  position: relative;
  top: 60px;
  left: 25px;
  display: flex;
  align-items: center;
  justify-content: center;
  width: 50px;
  height: 40px;
  border-radius: 5px;
  background-image: linear-gradient(to bottom left, #ffecc7, #d0b978);
  overflow: hidden;
}
.chip .chip-line {
  position: absolute;
  width: 100%;
  height: 1px;
  background-color: #333;
}
.chip .chip-line:nth-child(1) {
  top: 13px;
}
.chip .chip-line:nth-child(2) {
  top: 20px;
}
.chip .chip-line:nth-child(3) {
  top: 28px;
}
.chip .chip-line:nth-child(4) {
  left: 25px;
  width: 1px;
  height: 50px;
}
.chip .chip-main {
  width: 20px;
  height: 25px;
  border: 1px solid #333;
  border-radius: 3px;
  background-image: linear-gradient(to bottom left, #efdbab, #e1cb94);
  z-index: 1;
}
.wave {
  position: relative;
  top: 20px;
  left: 100px;
}
.card-number {
  position: relative;
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin: 40px 25px 10px;
  font-size: 23px;
  font-family: 'cc font', monospace;
}
.end {
  margin-left: 25px;
  text-transform: uppercase;
  font-family: 'cc font', monospace;
}
.end .end-text {
  font-size: 9px;
  color: rgba(255,255,255,0.8);
}
.card-holder {
  margin: 10px 25px;
  text-transform: uppercase;
  font-family: 'cc font', monospace;
}
.master {
  position: absolute;
  right: 20px;
  bottom: 20px;
  display: flex;
}
.master .circle {
  width: 25px;
  height: 25px;
  border-radius: 50%;
}
.master .master-red {
  background-color: #eb001b;
}
.master .master-yellow {
  margin-left: -10px;
  background-color: rgba(255,209,0,0.7);
}
.card {
  perspective: 1000;
}
/* .card:hover .flip {
  transform: rotateY(180deg);
} */
.back {
  transform: rotateY(180deg) translateZ(0);
  background: #9e9e9e;
}
.back .strip-black {
  position: absolute;
  top: 30px;
  left: 0;
  width: 100%;
  height: 50px;
  background: #000;
}
.back .ccv {
  position: absolute;
  top: 110px;
  left: 0;
  right: 0;
  height: 36px;
  width: 90%;
  padding: 10px;
  margin: 0 auto;
  border-radius: 5px;
  text-align: right;
  letter-spacing: 1px;
  color: #000;
  background: #fff;
}
.back .ccv label {
  display: block;
  margin: -30px 0 15px;
  font-size: 10px;
  text-transform: uppercase;
  color: #fff;
}
.back .terms {
  position: absolute;
  top: 150px;
  padding: 20px;
  font-size: 10px;
  text-align: justify;
}

@-webkit-keyframes flip {
  0%, 100% {
    transform: rotateY(0deg);
  }
  50% {
    transform: rotateY(180deg);
  }
}
@keyframes flip {
  0%, 100% {
    transform: rotateY(0deg);
  }
  50% {
    transform: rotateY(180deg);
  }
}
     .error-message {
            color: white;
            display: <% if (request.getAttribute("errorMessage") != null) { %>block<% } else { %>none<% } %>;
        }
</style>

<body>
    <!-- partial:index.partial.html -->
    <div class="backgound">
    
        <div class="left"></div>
        <div class="right">
            <div class="strip-bottom"></div>
            <div class="strip-top"></div>
        </div>

        <div
            style="position: absolute; left: 50%; top: 10%; transform: translate(-50%, -50%); display: flex; align-items: center;">

	           <h2 style="color: white; margin: 0 20px;">
                <span style="color: green;">HT</span><span style="color: yellow;">Shop</span>
            </h2>
            

        </div>
    </div>
    <div class="center">
        <div class="card">
            <div class="flip">
                <div class="front">
                    <div class="strip-bottom"></div>
                    <div class="strip-top"></div>

                    <div class="makeCen">
                        <h2>Login</h2>
                        
                    </div>
                        <form action="<%=request.getContextPath()%>/" method="post">
                    <div class="nes-field" style="position: absolute; top: 13%;width: 100%;padding: 20px;">
                        <label for="name_field">Username</label>
                        <input type="text" placeholder="Username" style="border-image-source:unset;" name="username_login"
                            class="nes-input">
                    </div>

                    <div class="nes-field" style="position: absolute; top: 38%;width: 100%;padding: 20px;">
                        <label for="name_field">Password</label>
                        <input type="text" placeholder="Password" style="border-image-source:unset;" name="password_login"
                            class="nes-input">
                    </div>

                    <div id="register-link" class="nes-field"
                        style="position: absolute; top: 61%;width: 100%;padding: 20px; font-size: 9px;">
                        <div>Don't have an account? <a href="http://localhost:8080/T1/resgister">Register</a></div>
                    </div>
                    <button type="submit" class="nes-btn is-primary makeCen"
                    style="top:unset; bottom: 6%;">Login</button>
                     <% if (request.getAttribute("errorMessage") != null) { %>
        <script type="text/javascript">
        var errorMessage = '<%= request.getAttribute("errorMessage") %>';
        alert(errorMessage);
        </script>
    <% } %>
                    
                    </form>
                   
                   </div>
                   
                     </div>
        </div>
            </div>
                              
    <div
            style="position: absolute; left: 50%; bottom: 10%; transform: translate(-50%, -50%); display: flex; align-items: center;">

            <div class="nes-container is-rounded" style="background-color: white;display: none;" id="message">
                
            </div>
            
        </div>
    
</body>


</html>