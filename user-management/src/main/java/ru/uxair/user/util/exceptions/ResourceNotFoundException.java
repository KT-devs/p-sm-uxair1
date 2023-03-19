package ru.uxair.user.util.exceptions;

public class ResourceNotFoundException extends AbstractResourceNotFoundException{
    public ResourceNotFoundException(String resourceId) {
        super(resourceId);
    }

    @Override
    protected String getResourceAlias() {
        return "Document";
    }
}
