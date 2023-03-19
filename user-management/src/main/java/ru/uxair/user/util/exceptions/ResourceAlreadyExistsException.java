package ru.uxair.user.util.exceptions;

public class ResourceAlreadyExistsException extends AbstractResourceAlreadyExistsException{
    public ResourceAlreadyExistsException(String resourceId) {
        super(resourceId);
    }

    @Override
    protected String getResourceAlias() {
        return "Passenger";
    }
}
