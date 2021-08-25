angular.module('market-front').controller('cartController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/market/';

    $scope.loadCart = function () {
        $http.get(contextPath + 'api/v1/cart')
            .then(function (response) {
                console.log(response);
                $scope.cartProducts = response.data;
            });
    };

    $scope.removeProductFromCart = function (product) {
        $http({
            url: contextPath + 'api/v1/cart',
            method: 'DELETE',
            params: {
                p: product.id
            }
        }).then(function (response) {
            console.log(response);
            $scope.loadCart();
        });
    }

    $scope.loadCart();
});