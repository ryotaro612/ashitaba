#!/usr/bin/env -S node --enable-source-maps
// import http from "node:http";
// import { OidcClient } from "oidc-client-ts";
// import { parseCmdLine } from "./args.ts";

import { argv } from "node:process";
import { parseCmdLine } from "./args.ts";

// async function connect() {
//   console.log(
//     parseCmdLine(["--port", "36332", "--env", "production", "--help"])
//   );
//   const client = new OidcClient({
//     authority: "https://accounts.google.com",
//     client_id: "",
//     client_secret: "",
//     redirect_uri: "http://localhost:36332/callback",
//   });
//   const req = await client.createSigninRequest({});
//   const server = http.createServer(
//     async (_req: http.IncomingMessage, res: http.ServerResponse) => {
//       //res.writeHead(302, { Location: req.url });
//       res.statusCode = 200;
//       res.end();
//     }
//   );
//   server.listen(36332, () => {});
//   server.close();

//   console.log(req.url);
// }

// connect();
// console.log("Server is running on http://localhost:36332");

const command = parseCmdLine(argv.slice(2));
if (command.error) {
  console.error(command.error);
  process.exit(1);
}
