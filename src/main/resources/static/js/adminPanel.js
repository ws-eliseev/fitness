import {getAllRoles, getAllUsers, getCurrentUser, isAdmin, roleName, saveNewUser} from "./getSetObjects.js";
import {delUserModalDialog, editUserModalDialog} from "./modalDialog.js";

const renderAdminPanel = async () => {
    const allUsers = await getAllUsers();
    const tableUsersList = document.getElementById("usersList");
    const tbody = tableUsersList.getElementsByTagName("TBODY")[0];
    tbody.innerHTML = "";
    addHeaders(tbody, false);
    allUsers.forEach(user => addRow(user, tbody, false));
}

export const renderBlackMenu = (user) => {
    const blackMenu = document.getElementsByClassName("p-2 w-100 bg-dark fs-5")[0];
    blackMenu.innerHTML = "<b>" + user.email + "</b>" + " with roles: " + arrayRolesToComaList(user.roles);
}

export const setEventListenners = () => {
    const newUserMenu = document.getElementById("newUserMenu");
    newUserMenu.addEventListener("click", () => newUserTab());
    const usersTableMenu = document.getElementById("usersTableMenu");
    usersTableMenu.addEventListener("click", () => showAdminPanelTab());
    const userPanel = document.getElementById("userPanel");
    userPanel.addEventListener("click", () => showUserPanel());
    const userPanelNewTab = document.getElementById("userPanelNewTab");
    userPanelNewTab.addEventListener("click", () => showUserPanel());
    const adminPanel = document.getElementById("adminPanel");
    adminPanel.addEventListener("click", () => showAdminPanelTab());
    const addNewUserButton = document.getElementById("addNewUserButton");
    addNewUserButton.addEventListener("click", () => addNewUser());
}

const renderUserPanel = async () => {
    let user = await getCurrentUser();
    const adminPanelMenu = document.getElementById("adminPanel");
    if (isAdmin(user)) {
        adminPanelMenu.classList.remove("visually-hidden");
    } else {
        adminPanelMenu.classList.add("visually-hidden");
    }
    const tableUsersList = document.getElementById("usersTable");
    const tbody = tableUsersList.getElementsByTagName("TBODY")[0];
    tbody.innerHTML = "";
    addHeaders(tbody, true);
    addRow(user, tbody, true);
}

const newUserTab = async () => {
    const newRoles = document.getElementById("newRoles");
    newRoles.innerHTML = "";
    (await getAllRoles()).forEach(role => {
        let option = document.createElement("option");
        option.append(document.createTextNode(role.name));
        option.value = role.id;
        newRoles.append(option);
    });
    const adminPanelTab = document.getElementById("adminPanelTab");
    adminPanelTab.classList.add("visually-hidden");
    const currentUserView = document.getElementById("currentUserView");
    currentUserView.classList.add("visually-hidden");
    const newUserTab = document.getElementById("newUserTab");
    newUserTab.classList.remove("visually-hidden");
}

export const showAdminPanelTab = () => {
    const newUserTab = document.getElementById("newUserTab");
    newUserTab.classList.add("visually-hidden");
    const currentUserView = document.getElementById("currentUserView");
    currentUserView.classList.add("visually-hidden");
    renderAdminPanel();
    const adminPanelTab = document.getElementById("adminPanelTab");
    adminPanelTab.classList.remove("visually-hidden");
}

const addNewUser = async () => {
    const firstName = document.getElementById("newFirstName").value;
    const lastName = document.getElementById("newLastName").value;
    const age = document.getElementById("newAge").value;
    const place = document.getElementById("newPlace").value;
    const email = document.getElementById("newEmail").value;
    const password = document.getElementById("newPassword").value;
    const roles = rolesFromOptionArray(document.getElementById("newRoles").options);
    const user = {id: 0, email , password, firstName, lastName, age, place, roles};
    await saveNewUser(user);
    showAdminPanelTab();
}

export const showUserPanel = () => {
    const newUserTab = document.getElementById("newUserTab");
    newUserTab.classList.add("visually-hidden");
    const adminPanelTab = document.getElementById("adminPanelTab");
    adminPanelTab.classList.add("visually-hidden");
    renderUserPanel();
    const currentUserView = document.getElementById("currentUserView");
    currentUserView.classList.remove("visually-hidden");
}

const addRow = (user, tbody, isWithoutOperationsColumn) => {
    const row = document.createElement("tr");
    const td = [];
    let end = isWithoutOperationsColumn ? 7 : 8;
    for (let i = 0; i < end; i++) {
        td[i] = document.createElement("td");
    }
    td[0].append(document.createTextNode(user.id));
    td[1].append(document.createTextNode(user.firstName));
    td[2].append(document.createTextNode(user.lastName));
    td[3].append(document.createTextNode(user.age));
    td[4].append(document.createTextNode(user.place));
    td[5].append(document.createTextNode(user.email));
    td[6].append(document.createTextNode(arrayRolesToComaList(user.roles)));
    if (!isWithoutOperationsColumn) {
        const buttonEdit = document.createElement("button");
        buttonEdit.setAttribute("data-bs-toggle", "modal");
        buttonEdit.setAttribute("data-bs-target", "#editUser");
        buttonEdit.addEventListener("click", () => editUserModalDialog(user.id));
        buttonEdit.classList.add("btn", "btn-info");
        buttonEdit.append(document.createTextNode("Edit"));
        const buttonDel = document.createElement("button");
        buttonDel.setAttribute("data-bs-toggle", "modal");
        buttonDel.setAttribute("data-bs-target", "#editUser");
        buttonDel.addEventListener("click", () => delUserModalDialog(user.id))
        buttonDel.classList.add("btn", "btn-danger");
        buttonDel.append(document.createTextNode("Delete"));
        td[7].append(buttonEdit, buttonDel);
        td[7].setAttribute("style", "width: 155px;");
    }
    row.append(...td);
    tbody.append(row);
}

const addHeaders = (tbody, isWithoutOperationsColumn) => {
    const headers = document.createElement("tr");
    const th = [];
    let end = isWithoutOperationsColumn ? 7 : 8;
    for (let i = 0; i < end; i++) {
        th[i] = document.createElement("th");
    }
    th[0].append(document.createTextNode("ID"));
    th[1].append(document.createTextNode("Firstname"));
    th[2].append(document.createTextNode("Lastname"));
    th[3].append(document.createTextNode("Age"));
    th[4].append(document.createTextNode("Location"));
    th[5].append(document.createTextNode("Email"));
    th[6].append(document.createTextNode("Roles"));
    if (!isWithoutOperationsColumn) {
        th[7].append(document.createTextNode("Operations"));
        th[7].classList.add("text-center");
    }
    headers.append(...th);
    tbody.append(headers);
}

const arrayRolesToComaList = (roles) => {
    let string = "";
    roles.forEach(role => string += roleName(role.name) + ", ");
    return string.substr(0, string.length - 2);
}

export const rolesFromOptionArray = arrayRoles => {
    const roles = [];
    let iter = 0;
    for (let option of arrayRoles) {
        if (option.selected) {
            roles[iter++] = {
                id: option.value,
                name: "ROLE_" + option.text,
                users: null
            }
        }
    }
    return roles;
}