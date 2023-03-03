
window.addEventListener("load", (e) => {
    fetch("http://localhost:8080/ohgym/suggestGo")
      .then((resp) => resp.json())
      .then((arr) => {

        let span = document.createElement("span");
        span.innerText = `(${arr.length})`;

        // let history = document.querySelector("#history > h3");
        // history.append(span);

        let suggestTest = document.getElementById("detailRequest");

        let template = document.getElementById("detailRequest-card-temp");
        
        arr.forEach((elem) => {
          let importTemplate = document.importNode(template.content, true);
          let firstP = importTemplate.querySelector("p");
          let secondP = firstP.nextElementSibling;
          let thirdP = secondP.nextElementSibling;
          firstP.innerText = elem.teacher_id;
          secondP.innerText = elem.message;
          // thirdP.innerText = elem.price;
          suggestTest.append(importTemplate);  
        });
      });
  });
  