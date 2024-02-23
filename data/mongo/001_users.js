db.createUser(
    {
        user: "simpleBankRootUser",
        pwd: "simpleBankSecretPassword",
        roles:[
            {
                role: "readWrite",
                db:   "simpleBank"
            }
        ]
    }
);