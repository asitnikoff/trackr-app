from rest_framework.views import APIView
from rest_framework.response import Response
from rest_framework import status
from rest_framework import permissions
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


class RoleListApiView(APIView):
    def get(self, request):
        roles = Role.objects
        serializer = RoleSerializer(roles, many=True)
        return Response(serializer.data, status=status.HTTP_200_OK)

    def post(self, request):
        data = {
            'title': request.data.get('title')
        }
        serializer = RoleSerializer(data=data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializ5er.data, status=status.HTTP_201_CREATED)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)


class RoleDetailApiView(APIView):

    def get_object(self, role_id):
        try:
            return Role.objects.get(role_id=role_id)
        except Role.DoesNotExist:
            return None

    # 3. Retrieve
    def get(self, request, role_id):
        role_instance = self.get_object(role_id)
        if not role_instance:
            return Response(
                {"res": "Object with role_id dose not exists"},
                status=status.HTTP_400_BAD_REQUEST
            )
        serializer = RoleSerializer(role_instance)
        return Response(serializer.data, status=status.HTTP_200_OK)

    # 4. Update
    def put(self, request, role_id):
        role_instance = self.get_object(role_id)
        if not role_instance:
            return Response(
                {"res": "Object with role id dose not exists"},
                status=status.HTTP_400_BAD_REQUEST
            )
        data = {
            'title': request.data.get('title')
        }
        serializer = RoleSerializer(instance=role_instance, data=data, partial=True)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data, status=status.HTTP_200_OK)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

    # 4. Delete
    def delete(self, request, role_id):
        role_instance = self.get_object(role_id)
        if not role_instance:
            return Response(
                {"res": "Object with todo id does not exists"},
                status=status.HTTP_400_BAD_REQUEST
            )
        role_instance.delete()
        return Response(
            {"res": "Object deleted"},
            status=status.HTTP_200_OK
        )


class ProjectListApiView(APIView):
    def get(self, request):
        projects = Project.objects
        serializer = ProjectSerializer(projects, many=True)
        return Response(serializer.data, status=status.HTTP_200_OK)

    def post(self, request):
        data = {
            'project_slug': request.data.get('project_slug'),
            'project_name': request.data.get('project_name'),
            'description': request.data.get('description')
        }
        serializer = ProjectSerializer(data=data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializ5er.data, status=status.HTTP_201_CREATED)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)


class ProjectDetailApiView(APIView):
    def get_object(self, project_id):
        try:
            return Project.objects.get(project_id=project_id)
        except Project.DoesNotExist:
            return None

    # 3. Retrieve
    def get(self, request, project_id):
        project_instance = self.get_object(project_id)
        if not project_instance:
            return Response(
                {"res": "Object with project_id dose not exists"},
                status=status.HTTP_400_BAD_REQUEST
            )
        serializer = ProjectSerializer(project_instance)
        return Response(serializer.data, status=status.HTTP_200_OK)

    # 4. Update
    def put(self, request, project_id):
        project_instance = self.get_object(project_id)
        if not project_instance:
            return Response(
                {"res": "Object with project_id dose not exists"},
                status=status.HTTP_400_BAD_REQUEST
            )
        data = {
            'project_slug': request.data.get('project_slug'),
            'project_name': request.data.get('project_name'),
            'description': request.data.get('description')
        }
        serializer = ProjectSerializer(instance=project_instance, data=data, partial=True)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data, status=status.HTTP_200_OK)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

    # 4. Delete
    def delete(self, request, project_id):
        project_instance = self.get_object(project_id)
        if not project_instance:
            return Response(
                {"res": "Object with project_id does not exists"},
                status=status.HTTP_400_BAD_REQUEST
            )
        project_instance.delete()
        return Response(
            {"res": "Object deleted"},
            status=status.HTTP_200_OK
        )


class UserListApiView(APIView):
    def get(self, request):
        users = User.objects
        serializer = UserSerializer(users, many=True)
        return Response(serializer.data, status=status.HTTP_200_OK)

    '''
        TODO
        1. add fields: projects, roles
    '''
    def post(self, request):
        data = {
            'name': request.data.get('name'),
            'surname': request.data.get('surname'),
            'patronymic': request.data.get('patronymic'),
            'email': request.data.get('email'),
            'login': request.data.get('login'),
            'password': request.data.get('password'),
        }
        serializer = UserSerializer(data=data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data, status=status.HTTP_201_CREATED)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)


class UserDetailApiView(APIView):
    def get_object(self, user_id):
        try:
            return User.objects.get(user_id=user_id)
        except User.DoesNotExist:
            return None

    # 3. Retrieve
    def get(self, request, user_id):
        user_instance = self.get_object(user_id)
        if not user_instance:
            return Response(
                {"res": "Object with user_id dose not exists"},
                status=status.HTTP_400_BAD_REQUEST
            )
        serializer = UserSerializer(user_instance)
        return Response(serializer.data, status=status.HTTP_200_OK)

    # 4. Update
    def put(self, request, user_id):
        user_instance = self.get_object(user_id)
        if not user_instance:
            return Response(
                {"res": "Object with user_id dose not exists"},
                status=status.HTTP_400_BAD_REQUEST
            )
        data = {
            'name': request.data.get('name'),
            'surname': request.data.get('surname'),
            'patronymic': request.data.get('patronymic'),
            'projects': request.data.get('projects'),
            'email': request.data.get('email'),
            'phone_number': request.data.get('phone_number'),
            'telegram_id': request.data.get('telegram_id'),
            'vk_id': request.data.get('vk_id'),
            'login': request.data.get('login'),
            'password': request.data.get('password'),
            'roles': request.data.get('roles'),
        }
        serializer = UserSerializer(instance=user_instance, data=data, partial=True)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data, status=status.HTTP_200_OK)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

    # 4. Delete
    def delete(self, request, user_id):
        user_instance = self.get_object(user_id)
        if not user_instance:
            return Response(
                {"res": "Object with user_id does not exists"},
                status=status.HTTP_400_BAD_REQUEST
            )
        user_instance.delete()
        return Response(
            {"res": "Object deleted"},
            status=status.HTTP_200_OK
        )


class TagListApiView(APIView):

    # 1. List all
    def get(self, request):
        tags = Tag.objects
        serializer = TagSerializer(tags, many=True)
        return Response(serializer.data, status=status.HTTP_200_OK)

    # 2. Create
    def post(self, request):
        data = {
            'title': request.data.get('title'),
        }
        serializer = TagSerializer(data=data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data, status=status.HTTP_201_CREATED)

        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)


class TagDetailApiView(APIView):
    def get_object(self, tag_id):
        try:
            return Tag.objects.get(tag_id=tag_id)
        except Tag.DoesNotExist:
            return None

    # 3. Retrieve
    def get(self, request, tag_id):
        tag_instance = self.get_object(tag_id)
        if not tag_instance:
            return Response(
                {"res": "Object with tag_id dose not exists"},
                status=status.HTTP_400_BAD_REQUEST
            )
        serializer = TagSerializer(tag_instance)
        return Response(serializer.data, status=status.HTTP_200_OK)

    # 4. Update
    def put(self, request, tag_id):
        tag_instance = self.get_object(tag_id)
        if not tag_instance:
            return Response(
                {"res": "Object with user_id dose not exists"},
                status=status.HTTP_400_BAD_REQUEST
            )
        data = {
            'title': request.data.get('title'),
        }
        serializer = TagSerializer(instance=tag_instance, data=data, partial=True)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data, status=status.HTTP_200_OK)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

    # 4. Delete
    def delete(self, request, tag_id):
        tag_instance = self.get_object(tag_id)
        if not tag_instance:
            return Response(
                {"res": "Object with user_id does not exists"},
                status=status.HTTP_400_BAD_REQUEST
            )
        tag_instance.delete()
        return Response(
            {"res": "Object deleted"},
            status=status.HTTP_200_OK
        )


class PriorityListApiView(APIView):

    # 1. List all
    def get(self, request):
        priorities = Priority.objects
        serializer = PrioritySerializer(priorities, many=True)
        return Response(serializer.data, status=status.HTTP_200_OK)

    # 2. Create
    def post(self, request):
        data = {
            'title': request.data.get('title'),
        }
        serializer = PrioritySerializer(data=data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data, status=status.HTTP_201_CREATED)

        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)


class PriorityDetailApiView(APIView):
    def get_object(self, priority_id):
        try:
            return Priority.objects.get(priority_id=priority_id)
        except Priority.DoesNotExist:
            return None

    # 3. Retrieve
    def get(self, request, priority_id):
        priority_instance = self.get_object(priority_id)
        if not priority_instance:
            return Response(
                {"res": "Object with tag_id dose not exists"},
                status=status.HTTP_400_BAD_REQUEST
            )
        serializer = PrioritySerializer(priority_instance)
        return Response(serializer.data, status=status.HTTP_200_OK)

    # 4. Update
    def put(self, request, priority_id):
        priority_instance = self.get_object(priority_id)
        if not priority_instance:
            return Response(
                {"res": "Object with user_id dose not exists"},
                status=status.HTTP_400_BAD_REQUEST
            )
        data = {
            'title': request.data.get('title'),
        }
        serializer = PrioritySerializer(instance=priority_instance, data=data, partial=True)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data, status=status.HTTP_200_OK)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

    # 4. Delete
    def delete(self, request, priority_id):
        priority_instance = self.get_object(priority_id)
        if not priority_instance:
            return Response(
                {"res": "Object with user_id does not exists"},
                status=status.HTTP_400_BAD_REQUEST
            )
        priority_instance.delete()
        return Response(
            {"res": "Object deleted"},
            status=status.HTTP_200_OK
        )


class TaskListApiView(APIView):

    # 1. List all
    def get(self, request):
        '''
        List all the task items for given requested user
        '''
        tasks = Task.objects
        serializer = TaskSerializer(tasks, many=True)
        return Response(serializer.data, status=status.HTTP_200_OK)

    # 2. Create
    def post(self, request):
        '''
        Create the Task with given task data
        '''
        data = {
            'task_title': request.data.get('task_title'),
            'tags': request.data.get('tags'),
            'description': request.data.get('description'),
            'create_date': request.data.get('create_date'),
            'end_date': request.data.get('end_date'),
            'author': request.data.get('author'),
            'priority': request.data.get('priority'),
            'project': request.data.get('project'),
        }
        serializer = TaskSerializer(data=data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data, status=status.HTTP_201_CREATED)

        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)


class TaskDetailApiView(APIView):

    def get_object(self, task_id):
        '''
        Helper method to get the object with given task_id
        '''
        try:
            return Task.objects.get(task_id=task_id)
        except Task.DoesNotExist:
            return None

    # 3. Retrieve
    def get(self, request, task_id):
        task_instance = self.get_object(task_id)
        if not task_instance:
            return Response(
                {"res": "Object with task id dose not exists"},
                status=status.HTTP_400_BAD_REQUEST
            )
        serializer = TaskSerializer(task_instance)
        return Response(serializer.data, status=status.HTTP_200_OK)

    # 4. Update
    def put(self, request, task_id):
        '''
        Updates the task item with given task_id if exists
        '''
        task_instance = self.get_object(task_id)
        if not task_instance:
            return Response(
                {"res": "Object with task id dose not exists"},
                status=status.HTTP_400_BAD_REQUEST
            )
        data = {
            'task_title': request.data.get('task_title'),
            'tags': request.data.get('tags'),
            'description': request.data.get('description'),
            'end_date': request.data.get('end_date'),
            'start_date': request.data.get('start_date'),
            'close_date': request.data.get('close_date'),
            'priority': request.data.get('priority'),
            'is_open': request.data.get('is_open'),
        }
        serializer = TaskSerializer(instance=task_instance, data=data, partial=True)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data, status=status.HTTP_200_OK)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

    # 4. Delete
    def delete(self, request, task_id):
        '''
        Deletes the task item with given task_id if exists
        '''
        task_instance = self.get_object(task_id)
        if not task_instance:
            return Response(
                {"res": "Object with todo id does not exists"},
                status=status.HTTP_400_BAD_REQUEST
            )
        task_instance.delete()
        return Response(
            {"res": "Object deleted"},
            status=status.HTTP_200_OK
        )