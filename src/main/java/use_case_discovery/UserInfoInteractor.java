package use_case_discovery;

import use_case_signin_signup.UserRequestModel;

import java.util.Map;

public class UserInfoInteractor extends csvInteractor implements UserInfoInputBoundary {
    private final UserInfoInterface uPanel;
    private final UserInfoResponseModel responseModel;

    private final Map<String, UserRequestModel> otherUsersInfo;

    public UserInfoInteractor(UserInfoInterface uPanel){
        this.uPanel = uPanel;
        this.responseModel = new UserInfoResponseModel();

        this.otherUsersInfo = super.otherUsersInfo;

    }

    public void create(UserInfoRequestModel model){
        String userName = model.getUsername();
        UserRequestModel wantedInfo = otherUsersInfo.get(userName);
        Map<String, Object> userSetting = wantedInfo.getUserSetting();

        responseModel.setAge((Integer) userSetting.get("age"));
        responseModel.setName(wantedInfo.getName());
        responseModel.setHobby(wantedInfo.getAreaOfInterest());
        responseModel.setRelationshipType((String) userSetting.get("relationshipType"));

        uPanel.update(responseModel);

    }


}