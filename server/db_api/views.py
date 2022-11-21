from rest_framework.views import APIView
from rest_framework.response import Response
from rest_framework import status
from rest_framework import permissions
from rest_framework import generics
from .mixins import (
    MultipleFieldLookupMixin,
)
from .serializers import (
    RoleSerializer,
    ProjectSerializer,
    UserSerializer,
    TagSerializer,
    PrioritySerializer,
    TaskSerializer,
)
from .models import (
    Role,
    Project,
    User,
    Tag,
    Priority,
    Task,
)


class RoleListApiView(generics.ListCreateAPIView):
    queryset = Role.objects.all()
    serializer_class = RoleSerializer


class RoleDetailApiView(generics.RetrieveAPIView):
    queryset = Role.objects.all()
    serializer_class = RoleSerializer


class ProjectListApiView(generics.ListCreateAPIView):
    queryset = Project.objects.all()
    serializer_class = ProjectSerializer


class ProjectDetailApiView(generics.RetrieveAPIView):
    queryset = Project.objects.all()
    serializer_class = ProjectSerializer


class UserListApiView(generics.ListCreateAPIView):
    queryset = User.objects.all()
    serializer_class = UserSerializer


class UserDetailApiView(generics.RetrieveAPIView):
    queryset = User.objects.all()
    serializer_class = UserSerializer


class UserFindApiView(MultipleFieldLookupMixin, generics.RetrieveAPIView):
    serializer_class = UserSerializer
    lookup_fields = ['login']

    def get_queryset(self):
        queryset = User.objects.all()
        login = self.request.query_params.get('login')
        if (login is None):
            return queryset.get(pk=1)
        queryset = queryset.filter(login=login)
        return queryset


class TagListApiView(generics.ListCreateAPIView):
    queryset = Tag.objects.all()
    serializer_class = TagSerializer


class TagDetailApiView(generics.RetrieveAPIView):
    queryset = Tag.objects.all()
    serializer_class = TagSerializer


class PriorityListApiView(generics.ListCreateAPIView):
    queryset = Priority.objects.all()
    serializer_class = PrioritySerializer


class PriorityDetailApiView(generics.RetrieveAPIView):
    queryset = Priority.objects.all()
    serializer_class = PrioritySerializer


class TaskListApiView(generics.ListCreateAPIView):
    queryset = Task.objects.all()
    serializer_class = TaskSerializer


class TaskDetailApiView(generics.RetrieveAPIView):
    queryset = Task.objects.all()
    serializer_class = TaskSerializer