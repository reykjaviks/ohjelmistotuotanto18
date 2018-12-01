# Git



#### Tiedoston palautus commit-historiasta

1. Etsi tiedoston palautusajankohta
 `git log` tai `git log -3`

2. Merkkaa ylös commitin tunniste
 `34ea6a871fa212ca3578367abeb46e1ced203987`

3. Palauta tiedosto
`git checkout <commit_id> -- <filename>`

Tiedosto palautuu staging-alueelle.
