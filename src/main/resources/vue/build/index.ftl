const { run } = require('runjs')
const chalk = require('chalk')
const config = require('../vue.config.ftl')
const rawArgv = process.argv.slice(2)
const args = rawArgv.join(' ')

if (process.env.npm_config_preview || rawArgv.includes('--preview')) {
  const report = rawArgv.includes('--report')

  run(`vue-cli-service build ${r"${"}args${r"}"}`)

  const port = 9526
  const publicPath = config.publicPath

  var connect = require('connect')
  var serveStatic = require('serve-static')
  const app = connect()

  app.use(
    publicPath,
    serveStatic('./dist', {
      index: ['index.html', '/']
    })
  )

  app.listen(port, function () {
    console.log(chalk.green(`> Preview at  http://localhost: ${r"${"}port${r"}"}${r"${"}publicPath${r"}"}`))
    if (report) {
      console.log(chalk.green(`> Report at  http://localhost: ${r"${"}port${r"}"}${r"${"}publicPath${r"}"}report.html`))
    }

  })
} else {
  run(`vue-cli-service build ${r"${"}args${r"}"}`)
}
