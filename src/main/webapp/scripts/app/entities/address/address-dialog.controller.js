'use strict';

angular.module('drivaidApp').controller('AddressDialogController',
    ['$scope', '$stateParams', '$modalInstance', 'entity', 'Address',
        function($scope, $stateParams, $modalInstance, entity, Address) {
    	$scope.map = { center: { latitude: 45.965397, longitude: 24.678590 }, zoom: 7 };
        $scope.address = entity;
        $scope.load = function(id) {
            Address.get({id : id}, function(result) {
                $scope.address = result;
            });
        };

        var onSaveSuccess = function (result) {
            $scope.$emit('drivaidApp:addressUpdate', result);
            $modalInstance.close(result);
            $scope.isSaving = false;
        };

        var onSaveError = function (result) {
            $scope.isSaving = false;
        };

        $scope.save = function () {
            $scope.isSaving = true;
            if ($scope.address.id != null) {
                Address.update($scope.address, onSaveSuccess, onSaveError);
            } else {
                Address.save($scope.address, onSaveSuccess, onSaveError);
            }
        };

        $scope.clear = function() {
            $modalInstance.dismiss('cancel');
        };
}]);
