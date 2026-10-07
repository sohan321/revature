const jokeBtn = document.getElementById("joke-btn");
const jokeOutput = document.getElementById("joke-output");

jokeBtn.addEventListener("click", async () => {
  jokeOutput.textContent = "Loading...";
  try {
    const res = await fetch(
      "https://v2.jokeapi.dev/joke/Programming?safe-mode"
    );
    if (!res.ok) throw new Error(`Request failed: ${res.status}`);
    const data = await res.json();

    jokeOutput.textContent =
      data.type === "twopart"
        ? `${data.setup} ... ${data.delivery}`
        : data.joke;
  } catch (err) {
    jokeOutput.textContent = "Couldn't fetch a joke. Try again.";
    console.error(err);
  }
});
