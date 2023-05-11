import defaultSettings from '@/settings'

const title = defaultSettings.title || 'Vue Admin Template'

export default function getPageTitle(pageTitle) {
  if (pageTitle) {
    return `${r"${"}pageTitle${r"}"} - ${r"${"}title${r"}"}`
  }
  return `${r"${"}title${r"}"}`
}
