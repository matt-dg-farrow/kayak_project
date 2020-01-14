const equipmentData =
  axios.get("http://localhost:8080/getEquipment")
  // axios.get("/KayakProject/getEquipment")
  .then((response) => {
    console.log(response.data);
    return response.data;
  })
  .catch(error => {
    console.log(error.response)
  });


const customerData =
  axios.get("http://localhost:8080/getAllCustomers")
  // axios.get("/KayakProject/getAllCustomers")
  .then((response) => {
    console.log(response.data);
    return response.data;
  })
  .catch(error => {
    console.log(error.response)
  });



const customerList = document.getElementById("table-body");
const capacityText = document.getElementById("capacity")

function getCustomerInfo() {
  // if(customerList.innerHTML.length===0){
  customerData.then(customers => {
    for (let customer of customers) {
      console.log("####");
      let customerInfo = document.createElement("tr");

      let customerId = document.createElement("td")
      customerId.innerHTML = customer.id;
      customerId.className = "hidden";
      customerInfo.appendChild(customerId);

      let customerFirstName = document.createElement("td");
      customerFirstName.innerHTML = customer.custFirstName;
      customerInfo.appendChild(customerFirstName);

      let customerSurname = document.createElement("td");
      customerSurname.innerHTML = customer.custSurname;
      customerInfo.appendChild(customerSurname);

      let emergFirstName = document.createElement("td");
      emergFirstName.innerHTML = customer.emergFirstName;
      customerInfo.appendChild(emergFirstName);

      let emergSurname = document.createElement("td");
      emergSurname.innerHTML = customer.emergSurname;
      customerInfo.appendChild(emergSurname);

      let emergContactNumber = document.createElement("td");
      emergContactNumber.innerHTML = customer.emergContactNumber;
      customerInfo.appendChild(emergContactNumber);

      let emergRelation = document.createElement("td");
      emergRelation.innerHTML = customer.emergRelation;
      customerInfo.appendChild(emergRelation);

      let equipmentInfo = document.createElement("td")
      equipmentInfo.innerHTML = customer.equipment;
      equipmentInfo.className = "hidden";
      customerInfo.appendChild(equipmentInfo);

      customerList.appendChild(customerInfo);
    }
  })
}


function getCapacity() {
  let circle = document.getElementById("safety-circle");
  axios.get("http://localhost:8080/getCapacity")
    // axios.get("/KayakProject/getCapacity")
    .then((response) => {
      console.log(response.data);
      capacityText.innerHTML = response.data + "/300";
      if (response.data >= 150) {
        circle.className = "dot-orange";
      }
      if (response.data >= 250) {
        circle.className = "dot-red";
      }
      if (response.data < 150) {
        circle.className = "dot-green";
      }
    });
}

function tableSearch() {
  let tr, td, i, j, txtValue;
  tr = document.getElementById("table-of-customers").getElementsByTagName("tr");
  for (let i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[2];
    if (td) {
      txtValue = td.textContent || td.innerText;
      if (txtValue.toUpperCase().indexOf(document.getElementById("search-box").value.toUpperCase()) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }
  }
}

function highlight(e) {
  if (selected[0]) selected[0].className = '';
  e.target.parentNode.className = 'selected';
  console.log(e);
}

let table = document.getElementById('table-of-customers'),
  selected = table.getElementsByClassName('selected');
table.onclick = highlight;




function addEquipmentToCust() {
  let custData = document.getElementsByClassName("selected")[0].childNodes;
  let equipList = document.getElementsByClassName("form-check-input");
  let equipToBeSaved = [];
  for (let i = 0; i < equipList.length; i++) {
    if (equipList[i].checked) {
      equipToBeSaved.push(equipList[i].id);
    }
  }
  console.log(equipToBeSaved);
  axios.patch("http://localhost:8080/rentEquip/" + custData[0].innerHTML, equipToBeSaved)
    .then(response => {
      console.log(response);
      alert("Customer " + custData[1].innerHTML + " " + custData[2].innerHTML + "'s equipment saved.");
      decreaseStock(equipToBeSaved);
      location.reload();
    });
}


function decreaseStock(equipment) {
  let equipmentStock = document.getElementsByClassName("stock-number");
  let equipmentType = document.getElementsByClassName("stock-type");
  let kayakStock = equipmentStock[0].innerHTML
  let BAStock = equipmentStock[1].innerHTML
  let helmetStock = equipmentStock[2].innerHTML
  let paddleStock = equipmentStock[3].innerHTML
  for (i = 0; i < equipment.length; i++) {
    if (equipment[i].toUpperCase() == equipmentType[0].innerHTML.toUpperCase()) {
      equipmentStock[0].innerHTML = kayakStock - 1;
    }
    if (equipment[i].toUpperCase() == equipmentType[1].innerHTML.toUpperCase()) {
      equipmentStock[1].innerHTML = BAStock - 1;
    }
    if (equipment[i].toUpperCase() == equipmentType[2].innerHTML.toUpperCase()) {
      equipmentStock[2].innerHTML = helmetStock - 1;
    }
    if (equipment[i].toUpperCase() == equipmentType[3].innerHTML.toUpperCase()) {
      equipmentStock[3].innerHTML = paddleStock - 1;
    }
  }
}
// || equipment[i] == BA[1] || equipment[i] == helmet[1] || equipment[i] == paddle[1]

function addCustomer() {
  let letters = /^[A-Za-z]+$/;
  let newCustFirstName = document.getElementById("newCustFirstName").value;
  let newCustSurname = document.getElementById("newCustSurname").value;
  let newEmergFirstName = document.getElementById("newEmergFirstName").value;
  let newEmergSurname = document.getElementById("newEmergSurname").value;
  let newEmergContactNumber = document.getElementById("newEmergContactNumber").value;
  let newEmergRelation = document.getElementById("newEmergRelation").value;
  let failure;
  if (newCustFirstName.length == 0 || newCustSurname.length == 0 || newEmergFirstName.length == 0 ||
    newEmergSurname.length == 0 || newEmergContactNumber.length == 0 || newEmergRelation.length == 0) {
    alert("Not all fields have been filled.");
    failure = 1;
  }
  if (newCustFirstName.length > 50 || newCustSurname.length > 50 || newEmergFirstName.length > 50 ||
    newEmergSurname.length > 50) {
    alert("Invalid name.");
    failure = 1;
  }
  if (newEmergContactNumber.length != 11 || isNaN(newEmergContactNumber) === true) {
    alert("Invalid phone number.");
    failure = 1;
  }
  if (newEmergRelation.length > 50) {
    alert("Invalid emergency relation.")
    failure = 1;
  }
  if (!newCustFirstName.match(letters) || !newCustSurname.match(letters) || !newEmergFirstName.match(letters) ||
    !newEmergSurname.match(letters) || !newEmergRelation.match(letters)) {
    alert("Please only use letters when entering names or relations.")
    failure = 1;
  }
  if (failure != 1) {
    if (capacityText.innerText != "300/300") {
      axios.post("http://localhost:8080/createCustomer", {
        // axios.post('/KayakProject/createCustomer', {
        custFirstName: newCustFirstName,
        custSurname: newCustSurname,
        emergFirstName: newEmergFirstName,
        emergSurname: newEmergSurname,
        emergContactNumber: newEmergContactNumber,
        emergRelation: newEmergRelation,
        equipment: []
      }).then(response => {
        console.log(response);
        alert("Customer created.");
        location.reload();
      });
    } else {
      alert("Capacity reached, cannot add customer.")
    }
  }
}




function deleteCustomer() {
  let id = document.getElementsByClassName("selected")[0].childNodes[0].innerHTML;
  axios.delete("http://localhost:8080/deleteCustomer/" + id)
    // axios.delete("/KayakProject/deleteCustomer/" + id)
    .then(response => {
      console.log(response);
      location.reload();
      alert("Customer deleted.");
    })
}

function deleteAll() {
  axios.delete("http://localhost:8080/deleteAllCustomers")
    // axios.delete("/KayakProject/deleteAllCustomers")
    .then(response => {
      console.log(response);
      location.reload();
      alert("All customers deleted.");
    })
}