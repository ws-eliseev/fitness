import {actionButton, passwordMask} from "./constants.js";
import {deleteUser, editUser, getAllRoles, getCurrentUser, getUser} from "./getSetObjects.js";
import {showAdminPanelTab, rolesFromOptionArray, renderBlackMenu} from "./adminPanel.js";

export const editUserModalDialog = async userId => {
    setDialogElements(userId, "Edit user", actionButton.EDIT);
    renderDialogFields(await getUser(userId), true);
}

export const delUserModalDialog = async userId => {
    setDialogElements(userId, "Delete user", actionButton.DELETE);
    renderDialogFields(await getUser(userId), false);
}

const setDialogElements = (userId, captionText, button) => {
    const caption = document.getElementById("staticBLabel");
    caption.innerText = captionText;
    const actionBtn = document.getElementById("action-btn");
    switch (button) {
        case actionButton.EDIT: {
            actionBtn.textContent = "Edit";
            actionBtn.classList.add("btn-primary");
            actionBtn.classList.remove("btn-danger");
            const modalDialogButton = document.getElementById("action-btn");
            modalDialogButton.removeEventListener("click", () => deleteEditedUser());
            modalDialogButton.addEventListener("click", () => saveEditedUser());
            break;
        }
        case actionButton.DELETE: {
            actionBtn.textContent = "Delete";
            actionBtn.classList.remove("btn-primary");
            actionBtn.classList.add("btn-danger");
            const modalDialogButton = document.getElementById("action-btn");
            modalDialogButton.removeEventListener("click", () => saveEditedUser());
            modalDialogButton.addEventListener("click", () => deleteEditedUser());
            break;
        }
    }
}

const saveEditedUser = async () => {
    const id = document.getElementById("id").value;
    const firstName = document.getElementById("firstname").value;
    const lastName = document.getElementById("lastname").value;
    const age = document.getElementById("age").value;
    const place = document.getElementById("place").value;
    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;
    const roles = rolesFromOptionArray(document.getElementById("roles").options);
    const user = {id, email, password, firstName, lastName, age, place, roles};
    await editUser(user);
    renderBlackMenu(await getCurrentUser());
    showAdminPanelTab();
}

const deleteEditedUser = async () => {
    const id = document.getElementById("id").value;
    await deleteUser(id);
    showAdminPanelTab();
}

const renderDialogFields = async ({id, firstName, roles, lastName, age, place, email}, enabledInputFields) => {
    const idField = document.getElementById("id");
    const inFirstName = document.getElementById("firstname");
    const inLastName = document.getElementById("lastname");
    const inAge = document.getElementById("age");
    const inPlace = document.getElementById("place");
    const inEmail = document.getElementById("email");
    const inPassword = document.getElementById("password");
    const labelPassword = document.getElementById("labelPassword");
    const groupRole = document.getElementById("roles");
    groupRole.innerHTML = "";
    let allRoles = await getAllRoles();
    let listRoles = [];
    if (enabledInputFields) {
        allRoles.forEach(role => {
            roles.forEach(userRole => {role.checked = (role.checked || role.id === userRole.id)});
        });
        inPassword.classList.remove("visually-hidden");
        labelPassword.classList.remove("visually-hidden");
        listRoles = allRoles;
    } else {
        inPassword.classList.add("visually-hidden");
        labelPassword.classList.add("visually-hidden");
        allRoles.forEach(role => roles.forEach((userRole, iter) => {
            if (role.id === userRole.id) {
                listRoles[iter] = role;
                listRoles[iter].checked = false;
            }
        }));
    }
    listRoles.sort(r => r.checked ? -1 : 1).forEach(role => {
        let option = document.createElement("option");
        option.append(document.createTextNode(role.name));
        option.value = role.id;
        option.selected = role.checked;
        option.disabled = !enabledInputFields;
        groupRole.append(option);
    });
    idField.setAttribute("value", id);
    inFirstName.setAttribute("value", firstName);
    inFirstName.disabled = !enabledInputFields;
    inLastName.setAttribute("value", lastName);
    inLastName.disabled = !enabledInputFields;
    inAge.setAttribute("value", age);
    inAge.disabled = !enabledInputFields;
    inPlace.setAttribute("value", place);
    inPlace.disabled = !enabledInputFields;
    inEmail.setAttribute("value", email);
    inEmail.disabled = !enabledInputFields;
    inPassword.setAttribute("value", passwordMask);
}