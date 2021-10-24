angular.module('market-front').controller('userRegistrationController', function ($scope, $http, $location) {
    const contextPath = 'http://localhost:8189/market/';

    $scope.userRegistration = function () {
        if ($scope.newUser == null) {
            alert('Форма не заполнена');
            return;
        }
        $http.post(contextPath + 'api/v1/registration', $scope.newUser)
            .then(function successCallback (response) {
                $scope.newUser = null;
                alert('Пользователь ' + response.data.username + ' зарегистрирован');
                $location.path('/');
            }, function failureCallback (response) {
                console.log(response);
                alert(response.data.messages);
            });
    }
});