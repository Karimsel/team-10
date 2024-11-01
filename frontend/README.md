# frontend

This is an example project for a single page application frontend with Vue.js v3. The UI is accessible under http://localhost:5173.

## Prerequisites

Install Node.js and ensure that the root folder of its installation is added to your PATH. You can check with this command: echo %PATH% (or echo $PATH on Linux / Git Bash).

## Development Setup

There are multiple possibilities, here a few examples:
- [VSCode](https://code.visualstudio.com/) + [Volar](https://marketplace.visualstudio.com/items?itemName=Vue.volar) (and disable Vetur) + [TypeScript Vue Plugin (Volar)](https://marketplace.visualstudio.com/items?itemName=Vue.vscode-typescript-vue-plugin).
- [WebStorm](https://www.jetbrains.com/webstorm/) (brings the required plugins natively)
- your favorite text editor + CLI

## Project Setup

Install the required dependencies with
```sh
npm install
```

Then you are good to go with
```sh
npm run dev

# run and expose on port 8000
npm run dev -- --host --port 8000
```

There is a linter available:
```sh
npm run lint
```

To deploy your code to production, you can compile and minify using (creates the `dist/` directory)
```sh
npm run build
```

You can copy the newly created `dist/` directory to `../api/src/main/resources/static` and run it together with your spring-boot application.
```sh
rm -rf ../api/src/main/resources/static
cp -r dist ../api/src/main/resources/static
```

Alternatively, you can serve the frontend separately by running the `serve` command. For that, install it globally first:
```sh
npm install --global serve
```

Then run the frontend standalone like this:
```sh
serve -l 8000 dist/
```

If you are hosting your application somewhere else than on your localhost, you need to the public DNS address and port of your API backend.
For that, do the following:
```sh
export VITE_API_BASE_URL="http://abc12378-ab00-cd11-de22.ma.bw-cloud-instance.org:8001"

# then run either
npm run dev -- --host --port 8000

# or
npm run build
serve -l 8000 dist/
```
