angular.module('market-front').controller('productDetailsController', function ($scope, $http, $routeParams, $location) {
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
    }

    $scope.loadProduct();
});
