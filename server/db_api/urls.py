from django.urls import include, path
from .views import (
    RoleListApiView,
    RoleDetailApiView,
    ProjectListApiView,
    ProjectDetailApiView,
    UserListApiView,
    UserDetailApiView,
    TagListApiView,
    TagDetailApiView,
    PriorityListApiView,
    PriorityDetailApiView,
    TaskListApiView,
    TaskDetailApiView,
)


urlpatterns = [
    path('roles/', RoleListApiView.as_view()),
    path('roles/<int:role_id>/', RoleDetailApiView.as_view()),

    path('projects/', ProjectListApiView.as_view()),
    path('projects/<int:project_id>/', ProjectDetailApiView.as_view()),

    path('users/', UserListApiView.as_view()),
    path('users/<int:user_id>/', UserDetailApiView.as_view()),

    path('tags/', TagListApiView.as_view()),
    path('tags/<int:tag_id>/', TagDetailApiView.as_view()),

    path('priorities/', PriorityListApiView.as_view()),
    path('priorities/<int:priority_id>/', PriorityDetailApiView.as_view()),

    path('tasks/', TaskListApiView.as_view()),
    path('tasks/<int:task_id>/', TaskDetailApiView.as_view()),

    path('api-auth/', include('rest_framework.urls', namespace='rest_framework'))
]