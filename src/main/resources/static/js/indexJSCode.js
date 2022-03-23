import {showAdminPanelTab, setEventListenners, showUserPanel, renderBlackMenu} from "./adminPanel.js";
import {getCurrentUser, isAdmin} from "./getSetObjects.js";

setEventListenners();
let user = await getCurrentUser();
renderBlackMenu(user);
if (isAdmin(user)) {
    showAdminPanelTab(user);
} else {
    showUserPanel();
}
