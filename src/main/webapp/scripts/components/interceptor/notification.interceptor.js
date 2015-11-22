 'use strict';

angular.module('drivaidApp')
    .factory('notificationInterceptor', function ($q, AlertService) {
        return {
            response: function(response) {
                var alertKey = response.headers('X-drivaidApp-alert');
                if (angular.isString(alertKey)) {
                    AlertService.success(alertKey, { param : response.headers('X-drivaidApp-params')});
                }
                return response;
            }
        };
    });
