angular.module('market-front').controller('productDetailsController', function ($scope, $http, $routeParams, $location, $localStorage, $route) {
    const contextPath = 'http://localhost:8189/market/';

    $scope.loadProduct = function () {
        $http.get(contextPath + 'api/v1/products/' + $routeParams.productId + '/details')
            .then(function (response) {
                console.log(response);
                $scope.productDetails = response.data;
            });
    };

    $scope.navToProductsCatalog = function () {
        $location.path('/store');
    };

    $scope.createComment = function (content) {
        $http({
            url: contextPath + 'api/v1/comments',
            method: 'POST',
            data: {
                productId: $routeParams.productId,
                username: $localStorage.webMarketUser.username,
                content: content
            }
        })
            .then(function successCallback(response) {
                $scope.new_comment = null;
                alert('Комментарий добавлен');
                $route.reload();
            }, function failureCallback(response) {
                console.log(response);
                alert(response.data.messages);
            });
    };

    $scope.disabledCheckOut = function () {
        alert("Для того чтобы оставлять комментарии вы должны авторизоваться");
    };

    $scope.loadProduct();
});
