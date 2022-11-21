from django.urls import include, path
from .views import (
    RoleListApiView,
    RoleDetailApiView,
    ProjectListApiView,
    ProjectDetailApiView,
    UserListApiView,
    UserDetailApiView,
    UserFindApiView,
    TagListApiView,
    TagDetailApiView,
    PriorityListApiView,
    PriorityDetailApiView,
    TaskListApiView,
    TaskDetailApiView,
)


urlpatterns = [
    path('roles/', RoleListApiView.as_view()),
    path('roles/<int:pk>/', RoleDetailApiView.as_view()),

    path('projects/', ProjectListApiView.as_view()),
    path('projects/<int:pk>/', ProjectDetailApiView.as_view()),

    path('users/', UserListApiView.as_view()),
    path('users/<int:pk>/', UserDetailApiView.as_view()),
    path('users/find/', UserFindApiView.as_view()),

    path('tags/', TagListApiView.as_view()),
    path('tags/<int:pk>/', TagDetailApiView.as_view()),

    path('priorities/', PriorityListApiView.as_view()),
    path('priorities/<int:pk>/', PriorityDetailApiView.as_view()),

    path('tasks/', TaskListApiView.as_view()),
    path('tasks/<int:pk>/', TaskDetailApiView.as_view()),

    path('api-auth/', include('rest_framework.urls', namespace='rest_framework'))
]