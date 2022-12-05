from drf_writable_nested import (
    WritableNestedModelSerializer,
    UniqueFieldsMixin
)
from rest_framework import serializers
from .models import (
    Role,
    Project,
    User,
    Tag,
    Priority,
    Task,
)


class RoleSerializer(UniqueFieldsMixin, WritableNestedModelSerializer, serializers.ModelSerializer):
    class Meta:
        model = Role
        fields = [
            "role_id",
            "title"
        ]


class ProjectSerializer(UniqueFieldsMixin, WritableNestedModelSerializer, serializers.ModelSerializer):
    class Meta:
        model = Project
        fields = [
            "project_id",
            "project_slug",
            "project_name",
            "description",
        ]


class UserSerializer(UniqueFieldsMixin, WritableNestedModelSerializer, serializers.ModelSerializer):
    projects = ProjectSerializer(many=True)
    roles = RoleSerializer(many=True)

    class Meta:
        model = User
        fields = [
            "user_id",
            "name",
            "surname",
            "patronymic",
            "email",
            "phone_number",
            "telegram_id",
            "vk_id",
            "login",
            "password",
            "roles",
            "projects",
            "is_deleted",
        ]


class TagSerializer(UniqueFieldsMixin, WritableNestedModelSerializer, serializers.ModelSerializer):
    class Meta:
        model = Tag
        fields = [
            "tag_id",
            "title"
        ]


class PrioritySerializer(UniqueFieldsMixin, WritableNestedModelSerializer, serializers.ModelSerializer):
    class Meta:
        model = Priority
        fields = [
            "priority_id",
            "title"
        ]

class TaskSerializer(UniqueFieldsMixin, WritableNestedModelSerializer, serializers.ModelSerializer):
    # tags = TagSerializer(many=True)
    # performer = UserSerializer(many=False)
    author = UserSerializer(many=False)
    # priority = PrioritySerializer(many=False)
    project = ProjectSerializer(many=False)

    class Meta:
        model = Task
        fields = [
            "task_id",
            "task_title",
            "task_slug",
            # "tags",
            "description",
            # "create_date",
            # "end_date",
            # "open_date",
            # "close_date",
            # "performer",
            "author",
            # "priority",
            "is_open",
            "project"
        ]