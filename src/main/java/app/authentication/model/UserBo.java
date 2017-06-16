package app.authentication.model;

import app.common.domain.BusinessObject;

public class UserBo extends BusinessObject<UserDocument> {

    public UserBo(final UserDocument userDocument) {
        super(userDocument, UserDocument.class, "userRepository");
    }
}
