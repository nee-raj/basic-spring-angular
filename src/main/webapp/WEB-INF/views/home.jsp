<!doctype html>
<html>
<head>
<title>Hello AngularJS</title>
<link href="css/angular-bootstrap.css" rel="stylesheet">
<style type="text/css">
[ng\:cloak], [ng-cloak], .ng-cloak {
  display: none !important;
}
</style>
</head>

<body ng-app="hello">
  <div class="container">
    <h1>Greeting</h1>
    <div ng-controller="home" ng-cloak class="ng-cloak">
      <p>The ID is {{greeting.id}}</p>
      <p>The content is {{greeting.content}}</p>
    </div>
  </div>
  <script src="js/ui-bootstrap-tpls-0.13.3.min.js" type="text/javascript"></script>
  <script src="js/hello.js"></script>
</body>
</html>