function tableSearch() {
  let tr, td, i, j, txtValue;
  tr = document.getElementById("table-of-customers").getElementsByTagName("tr");
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[1];
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

function deleteCustomer() {
  let id = document.getElementsByClassName("selected")[0].childNodes[0].innerHTML;
  axios.delete("http://localhost:8080/deleteCustomer/" + id)
  // axios.delete("/KayakProject/deleteCustomer/" + id)
    .then(response => {
      console.log(response);
      location.reload();
    })
}

function addEquipmentToCust() {
  let custData = document.getElementsByClassName("selected")[0].childNodes;
  let equipList = document.getElementsByClassName("form-check-input");
  let custEquipment = [];
  // let usedEquip = 
  
  for (let i = 0; i < equipList.length; i++) {
    //     console.log(equipList[i].id)
        let equipId = equipList[i].id;
        if (equipList[i].checked) {
    //       console.log(equipId);
          equipmentData.then(equipment => {
            for (let equip of equipment) {
              if (equipId === equip.equipType) {
                customerData.then(customers =>{
                  for (let customer of customers) {
                    for (let j = 0; j < customer.equipment.length; j++) {
                      if (equip.id == customer.equipment[j].id) {
                        console.log("no");
                        console.log(equip.id);
                        console.log(customer.equipment[j].id)
                      }
                      else {
                        console.log("yes");
                      }
                    }
                  }})


              }
              }
            }
          )
        }
    
      }
        console.log(custEquipment);
    axios.put("http://localhost:8080/updateCustomer?id=" + custData[0].innerHTML, {
    // axios.put("/KayakProject/updateCustomer?id=" + custData[0].innerHTML, {
      custFirstName: custData[1].innerHTML,
      custSurname: custData[2].innerHTML,
      emergFirstName: custData[3].innerHTML,
      emergSurname: custData[4].innerHTML,
      emergContactNumber: custData[5].innerHTML,
      emergRelation: custData[6].innerHTML,
      equipment: custEquipment
    })
  }


  function addCustomer() {
    let newCustFirstName = document.getElementById("newCustFirstName").value;
    let newCustSurname = document.getElementById("newCustSurname").value;
    let newEmergFirstName = document.getElementById("newEmergFirstName").value;
    let newEmergSurname = document.getElementById("newEmergSurname").value;
    let newEmergContactNumber = document.getElementById("newEmergContactNumber").value;
    let newEmergRelation = document.getElementById("newEmergRelation").value;
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
        location.reload();
      });
  }
    else {
      alert("Capacity reached, cannot add customer.")
    }
  }


  const customerData =
    axios.get("http://localhost:8080/getAllCustomers")
    // axios.get("/KayakProject/getAllCustomers")
    .then((response) => {
      console.log(response.data);
      return response.data;
    });

  const equipmentData =
    axios.get("http://localhost:8080/getEquipment")
    // axios.get("/KayakProject/getEquipment")
    .then((response) => {
      console.log(response.data);
      return response.data;
    });

  const customerList = document.getElementById("table-body");

  const capacityText = document.getElementById("capacity")

    

  function getCapacity() {
    let circle = document.getElementById("safety-circle");
    axios.get("http://localhost:8080/getCapacity")
    // axios.get("/KayakProject/getCapacity")
    .then((response) => {
      console.log(response.data);
      capacityText.innerHTML = response.data + "/300";
      if (response.data >= 150 ) {
        circle.className = "dot-orange";
      }
      if (response.data >= 250) {
        circle.className = "dot-red";
      }
      if (response.data < 150) {
        circle.className = "dot-green";

      }
        
    });
    console.log(capacityText.innerHTM);
    

  }
 
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

        customerList.appendChild(customerInfo);
      }
    })
  }

  function deleteAll() {
    axios.delete("http://localhost:8080/deleteAllCustomers")
    // axios.delete("/KayakProject/deleteAllCustomers")
      .then(response => {
        console.log(response);
        location.reload();
      })
  }
