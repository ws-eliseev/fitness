import {baseUrl} from "./constants.js";

export const getAllRoles = async () => {
    let allRoles = [];
    await fetch(baseUrl + "/admin/getAllRoles", {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        }
    })
        .then(response => response.json())
        .then(role => role.map((r, iter) => allRoles[iter] =
            {
                id: r.id,
                name: roleName(r.name),
                checked: false,
            }
        ));
    return allRoles;
}

export const getUser = async userId => {
    let user = null;
    await fetch(baseUrl + "/admin/getUser/" + userId, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        }
    }).then(response => response.json()).then(u => user = u);
    return user;
}

export const getAllUsers = async () => {
    let allUsers = [];
    await fetch(baseUrl + "/admin/getAllUsers", {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        }
    })
        .then(response => response.json())
        .then(user => user.map((u, iter) => allUsers[iter] = u));
    return allUsers;
}

export const roleName = role => {
    return role.substr(role.indexOf("_") + 1).toUpperCase();
}

export const getCurrentUser = async () => {
    let user = null;
    await fetch(baseUrl + "/login", {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        }
    })
        .then(response => response.json())
        .then(u => user = u)
        .catch(error => console.log('error', error));
    return user;
}

export const saveNewUser = async (user) => {
    await fetch(baseUrl + "/admin/addNewUser", {
        method: "POST",
        mode: "cors",
        cache: "no-cache",
        credentials: "same-origin",
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        redirect: "follow",
        referrerPolicy: "no-referrer",
        body: JSON.stringify(user)
    });
}

export const editUser = async (user) => {
    await fetch(baseUrl + "/admin/editUser", {
        method: "PUT",
        mode: "cors",
        cache: "no-cache",
        credentials: "same-origin",
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        redirect: "follow",
        referrerPolicy: "no-referrer",
        body: JSON.stringify(user)
    });
}

export const deleteUser = async (id) => {
    await fetch(baseUrl + "/admin/deleteUser/" + id, {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        }
    });
}

export const ifIncludeRole = (roleArray, roleName) => {
    let hasRoleName = false;
    roleArray.forEach(r => {hasRoleName = hasRoleName || r.name === roleName});
    return hasRoleName;
}

export  const isAdmin = (user) => {
    return ifIncludeRole(user.roles, "ROLE_ADMIN");
}