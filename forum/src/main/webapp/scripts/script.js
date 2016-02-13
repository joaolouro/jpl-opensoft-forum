var forumApp = angular.module("forumApp", ["ngRoute"]);

forumApp.config(function($routeProvider, $locationProvider)
{
	$routeProvider
		.when("/home",
		{
			templateUrl : "pages/home.html",
			controller : "home_controller"
		})
		.when("/list_topics",
		{
			templateUrl : "pages/list_topics.html",
			controller : "list_topics_controller"
		})
		.when("/topic_details/:id",
		{
			templateUrl : "pages/topic_details.html",
			controller : "topic_details_controller"
		})
		.when("/create_topic_page",
		{
			templateUrl : "pages/create_topic.html",
			controller : "create_topic_controller"
		})
		.when("/submit_new_topic",
		{
			templateUrl : "pages/list_topics.html",
			controller : "list_topics_controller"
		})
		.otherwise(
		{
			redirectTo: "/home"
		});
});

forumApp.controller("home_controller", function($scope)
{
	$scope.title = "Welcome to Forum";
});


forumApp.controller("list_topics_controller", function($scope, $http)
{
	$scope.sortType = "-data_ultima_resposta";
	$scope.sortReverse = false;
	$scope.titulo_filter = "";
	$scope.search_autor = "";
	
	$http.get('http://localhost:8080/topic/list').success(function(data)
	{
		$scope.topics = data;
	});
	
	$scope.getCurrentDate = function()
	{
		return Date.now();
	}
	
	$scope.title = "Lista de Tópicos";
});

forumApp.controller("topic_details_controller", function($scope, $http, $routeParams)
{
	
	function getTopic(id)
	{
		var url =  "http://localhost:8080/topic/consult/" + $routeParams.id;
		$http.get(url).success(function(data)
		{
			$scope.topic = data;
			$scope.replies = data.respostas;
		});
	}
	
	getTopic($routeParams.id);
	
	$scope.reply_topic = function(reply)
	{
		var url = "http://localhost:8080/topic/respond";
			
		var reply_obj = {
				autor : reply.autor,
				mensagem : reply.message,
				topico_id : $routeParams.id
		};
		
		$http.post(url, reply_obj).success(function()
		{
			getTopic($routeParams.id)
		});
	}

	$scope.title = "Detalhe de Tópico";
});

forumApp.controller("create_topic_controller", function($scope, $http, $location)
{

	$scope.create_topic = function(topic)
	{
		var url = "http://localhost:8080/topic/create";
			
		var topic_obj = {
				titulo : topic.title,
				mensagem : topic.message,
				autor : topic.autor
		};
		
		$http.post(url, topic_obj).success(function()
		{
			$location.path("/list_topics");
		});
	}
	
	$scope.title = "Criar Tópico"
});