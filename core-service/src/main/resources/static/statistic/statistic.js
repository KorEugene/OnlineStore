angular.module('market-front').controller('statisticController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/market/';

    $scope.loadStatistic = function () {
        $http({
            url: contextPath + 'api/v1/statistic',
            method: 'GET'
        }).then(function (response) {
            console.log(response);
            $scope.statistic = response.data;
        });
    };

    $scope.loadStatistic();
});