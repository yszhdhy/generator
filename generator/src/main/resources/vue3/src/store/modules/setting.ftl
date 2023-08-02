import { defineStore } from 'pinia'

const useLayOutSettingStore = defineStore('SettingStore', {
    state: () => {
        return {
            isCollapse: false,
            refsh: false,
        }
    },
})

export default useLayOutSettingStore
