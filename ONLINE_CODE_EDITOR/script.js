// Function to switch between tabs
function openTab(event, tabId) {
    let tabs = document.getElementsByClassName("tab-content");
    let buttons = document.getElementsByClassName("tab-btn");

    // Hide all tabs
    for (let tab of tabs) {
        tab.classList.remove("active");
    }

    // Remove active class from all buttons
    for (let btn of buttons) {
        btn.classList.remove("active");
    }

    // Show the selected tab
    document.getElementById(tabId).classList.add("active");
    event.currentTarget.classList.add("active");
}

// Function to run the code and show preview
function runCode() {
    let htmlCode = document.getElementById("htmlTab").value;
    let cssCode = document.getElementById("cssTab").value;
    let jsCode = document.getElementById("jsTab").value;

    let output = document.getElementById("output").contentWindow.document;
    output.open();
    output.write(`
        <style>${cssCode}</style>
        ${htmlCode}
        <script>${jsCode}<\/script>
    `);
    output.close();
}

// Function to clear all code
function clearCode() {
    document.getElementById("htmlTab").value = "";
    document.getElementById("cssTab").value = "";
    document.getElementById("jsTab").value = "";
    runCode(); // Clear preview
}

// Function to download the code as a file
function downloadCode() {
    let htmlCode = document.getElementById("htmlTab").value;
    let cssCode = document.getElementById("cssTab").value;
    let jsCode = document.getElementById("jsTab").value;

    let blob = new Blob(
        [`<html>\n<head>\n<style>\n${cssCode}\n</style>\n</head>\n<body>\n${htmlCode}\n<script>\n${jsCode}\n</script>\n</body>\n</html>`],
        { type: "text/html" }
    );

    let a = document.createElement("a");
    a.href = URL.createObjectURL(blob);
    a.download = "code.html";
    a.click();
}
