package use_case_discovery;

import use_case_signin_signup.UserRequestModel;

import java.util.Map;

public class UserInfoInteractor extends csvInteractor implements UserInfoInputBoundary {
    private UserInfoInterface uPanel;
    private UserInfoResponseModel responseModel;

    private Map<String, UserRequestModel> otherUsersInfo;

    private UserInfoRequestModel model;

    private UserRequestModel wantedInfo;

    private Map<String, Object> userSetting;

    public UserInfoInteractor(UserInfoInterface uPanel){
        this.uPanel = uPanel;
        this.responseModel = new UserInfoResponseModel();

        this.otherUsersInfo = super.otherUsersInfo;

    }

    public void create(UserInfoRequestModel model){
        this.model = model;
        String userName = model.getUsername();
        wantedInfo = otherUsersInfo.get(userName);
        userSetting = wantedInfo.getUserSetting();

        responseModel.setAge((Integer) userSetting.get("age"));
        responseModel.setName(wantedInfo.getName());
        responseModel.setHobby(wantedInfo.getAreaOfInterest());
        responseModel.setRelationshipType((String) userSetting.get("relationshipType"));

        uPanel.update(responseModel);

    }


}
