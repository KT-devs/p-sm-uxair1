package ru.uxair.flight;

public abstract class AbstractResourceAlreadyExistsException extends RuntimeException {

    private final String message;

    protected AbstractResourceAlreadyExistsException(final String resourceId) {
        this.message = buildMessage(resourceId);
    }

    @Override
    public String getMessage() {
        return message;
    }

    private String buildMessage(final String resourceId) {
        return getResourceAlias() + " with id " +
                resourceId +
                " already exists.";
    }

    protected abstract String getResourceAlias();
}
