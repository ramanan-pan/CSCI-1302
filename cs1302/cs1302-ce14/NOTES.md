Apparently for-each loops do not work as we intended/expected
    with generic types in generic methods.

    Test code works.

    1. One is a generic method using generic arguments.
    2. The non-generic version will only catch errors at run-time, as opposed to
    the generic version as you are telling the compiler what type it should check for.