pipelineJob('PipelineDSJ-Home-1') {
    parameters {
		stringParam('ApplicationRepository',"$ApplicationRepo", "Application code repo to build")
    }
    definition {
        cps {
			def jobScript = readFileFromWorkspace('cithome.groovy')
			script(jobScript)
			def approvals = org.jenkinsci.plugins.scriptsecurity.scripts.ScriptApproval.get()
			approvals.approveScript(approvals.hash(jobScript,"groovy"))
        }
    }
}