function createTableCell(data) {
    const cell = document.createElement('td');

    let nameSpan = document.createElement('span');
    nameSpan.textContent = data["name"];
    cell.appendChild(nameSpan);
    cell.appendChild(document.createElement('br'));

    let priceSpan = document.createElement('span');
    priceSpan.textContent = `$${data["retailPrice"].toFixed(2)}`;
    cell.appendChild(priceSpan);
    cell.appendChild(document.createElement('br'));

    let doughSpan = document.createElement('span');
    doughSpan.textContent = `${data["doughName"]} (${data["doughSizeName"]})`;
    cell.appendChild(doughSpan);
    cell.appendChild(document.createElement('br'));

    let cheeseSpan = document.createElement('span');
    if (data.cheeseName1 === "No Cheese" && data.cheeseName2 === "No Cheese") {
        cheeseSpan.textContent = "No Cheese";
    } else if (data.cheeseName1 === "No Cheese" || data.cheeseLevelName2 === "No Cheese") {
        if (data.cheeseName1 === "No Cheese") {
            cheeseSpan.textContent = generateCheeseString(data.cheeseName2, data.cheeseLevelName2);
        } else {
            cheeseSpan.textContent = generateCheeseString(data.cheeseName1, data.cheeseLevelName1);
        }
    } else {
        if (data.cheeseLevelName1 == data.cheeseLevelName2 && data.cheeseName1 == data.cheeseName2) {
            cheeseSpan.textContent = generateCheeseString(data.cheeseName1, data.cheeseLevelName1);
        } else {
            let s1 = generateCheeseString(data.cheeseName1, data.cheeseLevelName1);
            let s2 = generateCheeseString(data.cheeseName2, data.cheeseLevelName2);
            cheeseSpan.textContent = `${s1} & ${s2}`;
        }
    }
    cell.appendChild(cheeseSpan);
    cell.appendChild(document.createElement('br'));

    let sauceSpan = document.createElement('span');
    if (data.sauceName === 'No Sauce') {
        sauceSpan.textContent = data.sauceName;
    } else {
        sauceSpan.textContent = `${data["sauceName"]} (${data["sauceIntensityName"]})`;
    }
    cell.appendChild(sauceSpan);
    cell.appendChild(document.createElement('br'));

    let toppingArr = [];
    if (data["toppingName1"] != "None") {
        toppingArr.push(data["toppingName1"]);
    }
    if (data["toppingName2"] != "None") {
        toppingArr.push(data["toppingName2"]);
    }
    if (data["toppingName3"] != "None") {
        toppingArr.push(data["toppingName3"]);
    }
    let toppingSpan = document.createElement('span');
    toppingSpan.textContent = toppingArr.join(" & ");
    cell.appendChild(toppingSpan);
    cell.appendChild(document.createElement('br'));

    return cell;
}

function generateCheeseString(cheeseName, cheeseLevel) {
    if (cheeseName !== 'No Cheese') {
        return `${cheeseName} (${cheeseLevel})`;
    } else {
        return cheeseName;
    }
}


function addButton() {
    let addToCartButton = document.createElement("button");
    addToCartButton.textContent = "Add to cart";
    addToCartButton.setAttribute("pizza-name", data["name"]);
    addToCartButton.addEventListener("click", function () {
        addSignaturePizza(this);
    });
    cell.appendChild(addToCartButton);
}
