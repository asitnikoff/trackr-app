from django.contrib import admin
from .models import (
    Role,
    Project,
    User,
    Tag,
    Priority,
    Task,
)

# Register your models here.
admin.site.register(Role)
admin.site.register(Project)
admin.site.register(User)
admin.site.register(Tag)
admin.site.register(Priority)
admin.site.register(Task)