<script setup>
// import { useWatch } from 'element-plus/es/components/slider/src/composables'
import { watch, reactive } from 'vue'
import gsap from 'gsap'
const props = defineProps({
  value: {
    type: Number,
    default: 0
  }
})

const d = reactive({ num: 0 })

function AnimateToValue() {
  gsap.to(d, {
    duration: 1,
    num: props.value
  })
}

AnimateToValue()

watch(
  () => props.value,
  () => AnimateToValue()
)
</script>

<template>
  {{ d.num.toFixed(0) }}
</template>

<style lang="scss" scoped></style>
